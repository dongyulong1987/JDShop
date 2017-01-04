package com.bawie.bawiestore.views.layoutviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 由于recycleView与grideview滑动冲突导致grideview只显示一行
 * 重写grideview的onMeasure方法可以解决
 * 创建人 dongyulong
 * 创建时间 2017/1/3  19:01.
 */

public class  MyGrideView extends GridView {


        public MyGrideView(Context context) {
//            super(context);
            this(context,null);
        }

        public MyGrideView(Context context, AttributeSet attrs) {
//            super(context, attrs);
            this(context,attrs,0);
        }

        public MyGrideView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                    MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);

        }

        @Override
        public int getNumColumns() {
            return 2;
        }
    }

