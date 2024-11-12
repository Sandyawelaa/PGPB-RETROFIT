package com.example.acara_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.acara_10.model.Data;
import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private List<Data> dataList;
    private LayoutInflater inflater;

    public UserAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_user, parent, false);
        }

        Data data = dataList.get(position);

        TextView tvSurveyor = convertView.findViewById(R.id.tv_surveyor);
        TextView tvUsia = convertView.findViewById(R.id.tv_usia);
        TextView tvGender = convertView.findViewById(R.id.tv_gender);
        TextView tvPekerjaan = convertView.findViewById(R.id.tv_pekerjaan);
        TextView tvDesa = convertView.findViewById(R.id.tv_desa);
        TextView tvLocation = convertView.findViewById(R.id.tv_location);

        tvSurveyor.setText("Surveyor: " + data.getNamaSurveyor());
        tvUsia.setText("Usia: " + data.getUsia());

        // Tambahkan logika untuk menambahkan keterangan jenis kelamin
        String genderDescription = "";
        if ("L".equalsIgnoreCase(data.getJenisKelamin())) {
            genderDescription = "Laki-Laki";
        } else if ("P".equalsIgnoreCase(data.getJenisKelamin())) {
            genderDescription = "Perempuan";
        } else {
            genderDescription = "Tidak Diketahui";
        }
        tvGender.setText("Jenis Kelamin: " + genderDescription);

        tvPekerjaan.setText("Pekerjaan: " + data.getPekerjaan());
        tvDesa.setText("Desa: " + data.getNamaDesa());
        tvLocation.setText("Location (Lat, Long): " + data.getLatitude() + ", " + data.getLongitude());

        return convertView;
    }

}
