package com.milabobo.android.sample.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.milabobo.android.sample.R;
import com.milabobo.android.sample.view.canvas.PagerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Practice extends AppCompatActivity {
    @BindView(R.id.tablayout)
    TabLayout layout;
    @BindView(R.id.pager)
    ViewPager pager;

    SampleMode[] modes = new SampleMode[] {
        new SampleMode(R.layout.practice1_layout, R.string.activity_view_canvas_practice1),
        new SampleMode(R.layout.practice2_layout, R.string.activity_view_canvas_practice2),
        new SampleMode(R.layout.practice3_layout, R.string.activity_view_canvas_practice3),
        new SampleMode(R.layout.practice4_layout, R.string.activity_view_canvas_practice4),
        new SampleMode(R.layout.practice5_layout, R.string.activity_view_canvas_practice5),
        new SampleMode(R.layout.practice6_layout, R.string.activity_view_canvas_practice6),
        new SampleMode(R.layout.practice7_layout, R.string.activity_view_canvas_practice7),
        new SampleMode(R.layout.practice8_layout, R.string.activity_view_canvas_practice8),
        new SampleMode(R.layout.practice9_layout, R.string.activity_view_canvas_practice9),
        new SampleMode(R.layout.practice10_layout, R.string.activity_view_canvas_practice10),
        new SampleMode(R.layout.practice11_layout, R.string.activity_view_canvas_practice11),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        ButterKnife.bind(this);

        FragmentPagerAdapter adapter =
                new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PagerFragment.newInstance(modes[position].layoutId);
            }

            @Override
            public int getCount() {
                return modes.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(modes[position].title);
            }
        };

        pager.setAdapter(adapter);
        layout.setupWithViewPager(pager);
    }

    private static class SampleMode {
        @LayoutRes int layoutId;
        @StringRes int title;

        public SampleMode(int layoutId, int title) {
            this.layoutId = layoutId;
            this.title = title;
        }
    }
}
