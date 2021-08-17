package com.example.mybestpractice.optimize;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ThreadUtils;
import com.example.mybestpractice.R;
import com.example.mybestpractice.optimize.async.ThreadPoolUtil;

public class OptimizeActivity extends AppCompatActivity implements ICallBack {
    ImageView img;
    ImageView testImgHook;
    Button btnThread;

    private static final String TAG = OptimizeActivity.class.getSimpleName();

   /* private static Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 模拟内存抖动
            for (int i = 0; i < 100; i++) {
                String[] arr = new String[10000];
            }
            handler.sendEmptyMessageDelayed(0, 50);
        }
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        img = findViewById(R.id.img);
        testImgHook = findViewById(R.id.test_imghook);
        btnThread = findViewById(R.id.btn_thread);
        /*new Handler().post(new Runnable() {
            @Override
            public void run() {
                Log.e("tag", "Msg执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
*/
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (OptimizeActivity.this) {
                    try {
                        Thread.sleep(20 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        //获取每个控件的耗时。必须在super.onCreate(savedInstanceState);之前调用，否则无效
        /*LayoutInflaterCompat.setFactory2(getLayoutInflater(), new LayoutInflater.Factory2() {
            @Nullable
            @Override
            public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
                if (TextUtils.equals("ImageView", name)) {
                    // 可通过这种方式创建自定义ImageView
                }
                long startTime = System.currentTimeMillis();
                View view = getDelegate().createView(parent, name, context, attrs);
                LogUtils.i(name + " cost" + (System.currentTimeMillis() - startTime));
                return view;
            }

            @Nullable
            @Override
            public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
                return null;
            }
        });*/

        // 通过AsyncLayoutInflater 异步加载布局
       /* new AsyncLayoutInflater(this).inflate(R.layout.activity_optimize, null, new AsyncLayoutInflater.OnInflateFinishedListener() {
            @Override
            public void onInflateFinished(@NonNull View view, int resid, @Nullable ViewGroup parent) {
                setContentView(view);
                //findViewById() 等操作
            }
        });*/

        super.onCreate(savedInstanceState);


        //通过AsyncLayoutInflater异步加载布局时，需要注释setContentView
        setContentView(R.layout.activity_optimize);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        img.setImageBitmap(bitmap);

        // 模拟检测大于Imageview宽高的图片
        testImgHook.setImageBitmap(bitmap);

        //模拟内存泄漏
        CallBackManager.addCallBack(this);
//        handler.sendEmptyMessage(1);

        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {

            }
        });

        //对dispatchMessage() 进行监控。
       /* Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {
                LogUtils.e(x);
            }
        });*/



       /* synchronized (OptimizeActivity.this){
            LogUtils.e("主线程获取了锁");
        }*/

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void doOperate() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 及时的注销callBack，防止内存泄漏
        CallBackManager.removeCallBack(this);
    }

    public void threadOnclick(View view) {
        ThreadPoolUtil.getService().execute(new Runnable() {
            @Override
            public void run() {
                // 在线程运行时可以修改线程的优先级
                Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
                String oldName = Thread.currentThread().getName();
                Log.e(TAG, oldName);
                //在线程运行时，可以修改线程名字，方便当前使用线程的用户调试
                Thread.currentThread().setName("newName");
                String newName = Thread.currentThread().getName();
                Log.e(TAG, newName);
                // ... 执行业务代码

                // 执行完后再修改回原来的线程名字
                Thread.currentThread().setName(oldName);
            }
        });
    }


    /*private long mStartFrameTime = 0;
    private int mFrameCount = 0;

    *//**
     * 单次计算FPS使用160毫秒
     *//*
    private static final long MONITOR_INTERVAL = 160L;
    private static final long MONITOR_INTERVAL_NANOS = MONITOR_INTERVAL * 1000L * 1000L;

    *//**
     * 设置计算fps的单位时间间隔1000ms,即fps/s
     *//*
    private static final long MAX_INTERVAL = 1000L;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void getFPS() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                if (mStartFrameTime == 0) {
                    mStartFrameTime = frameTimeNanos;
                }
                long interval = frameTimeNanos - mStartFrameTime;
                if (interval > MONITOR_INTERVAL_NANOS) {
                    double fps = (((double) (mFrameCount * 1000L * 1000L)) / interval) * MAX_INTERVAL;
                    // log输出fps
                    LogUtils.i("当前实时fps值为： " + fps);
                    mFrameCount = 0;
                    mStartFrameTime = 0;
                } else {
                    ++mFrameCount;
                }

                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }*/


}
