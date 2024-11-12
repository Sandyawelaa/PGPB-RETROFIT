package com.example.acara_10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.acara_10.model.Data;
import com.example.acara_10.network.ApiClient;
import com.example.acara_10.network.ApiService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private UserAdapter userAdapter;
    private List<Data> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewUsers);
        userAdapter = new UserAdapter(this, dataList);
        listView.setAdapter(userAdapter);

        // Create service
        ApiService client = ApiClient.getInstance();

        // Call the API to get users
        Call<List<Data>> response = client.getAllUsers();

        // Enqueue the call
        response.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataList.addAll(response.body());
                    userAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
