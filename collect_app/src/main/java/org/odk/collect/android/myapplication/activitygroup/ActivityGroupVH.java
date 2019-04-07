package org.odk.collect.android.myapplication.activitygroup;

import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.odk.collect.android.R;
import org.odk.collect.android.myapplication.activity.ActivityListActivity;
import org.odk.collect.android.myapplication.activitygroup.model.ActivityGroup;
import org.odk.collect.android.myapplication.beneficary.BeneficiariesActivity;
import org.odk.collect.android.myapplication.utils.ActivityUtil;

import java.util.HashMap;

class ActivityGroupVH extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvDesc, tvOutput;
    AppCompatImageButton btnExpand;

    ActivityGroupVH(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.primary_text);
        tvDesc = itemView.findViewById(R.id.sub_text);
        tvOutput = itemView.findViewById(R.id.supporting_text);
        btnExpand = itemView.findViewById(R.id.expand_button);

    }

    void bindView(ActivityGroup desc) {
        tvTitle.setText(desc.getName());
        tvDesc.setText(desc.getDescription());
        tvOutput.setText(desc.getOutput());
        btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvOutput.getVisibility() == View.VISIBLE) {
                    btnExpand.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    tvOutput.setVisibility(View.GONE);
                } else {
                    btnExpand.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    tvOutput.setVisibility(View.VISIBLE);
                }
            }
        });
        itemView.setOnClickListener(addClickListener(desc));
    }

    private View.OnClickListener addClickListener(ActivityGroup activityGroup) {
        return v -> {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("activity_group_id", activityGroup.getId());
            ActivityUtil.openActivity(ActivityListActivity.class, itemView.getContext(), hashMap, false);
        };
    }
}