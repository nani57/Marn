package com.marn.marn.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.marn.marn.R;
import com.marn.marn.utils.OnSwipeTouchListener;

public class CartActivity extends AppCompatActivity {

    private ImageView imageView, closeMore, addCustomers, backButton;
    private LinearLayout moreActionsLayout;
    private Button chargeButton;
    private RelativeLayout relativeLayout;
    private SwipeLayout swipeLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();
        imageView = findViewById(R.id.iv_more);
        moreActionsLayout = (LinearLayout) findViewById(R.id.ll_more);
        closeMore = findViewById(R.id.iv_close_more);
        addCustomers = findViewById(R.id.iv_add_customers);
        chargeButton = findViewById(R.id.charge_button);
        backButton = findViewById(R.id.backButton);
        relativeLayout = findViewById(R.id.rl_general);
        swipeLayout = findViewById(R.id.swipeLayout);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreActionsLayout.setVisibility(View.VISIBLE);
            }
        });
        closeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreActionsLayout.setVisibility(View.GONE);
            }
        });
        addCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this, AddCustomers.class);
                startActivity(i);
            }
        });
        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        swipeLayout.setLeftSwipeEnabled(false);

        //add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
        swipeLayout.addDrag(SwipeLayout.DragEdge.Left, findViewById(R.id.delete1));

    }
}
