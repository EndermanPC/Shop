package com.example.myapplication;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import android.view.View;
import android.Manifest;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> listProduct;
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;

    private static final int PERMISSION_REQUEST_CAMERA = 1;

    public void image_button_clicked_5(View view) {
        Context context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Chọn thông tin thông báo:");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Quản lý ứng dụng",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "Cài đặt bổ sung",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    class Product {
        String name;
        int price;
        int productID;

        public Product(int productID, String name, int price) {
            this.name = name;
            this.price = price;
            this.productID = productID;
        }

    }

    class ProductListViewAdapter extends BaseAdapter {
        final ArrayList<Product> listProduct;

        ProductListViewAdapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @Override
        public int getCount() {
            return listProduct.size();
        }

        @Override
        public Object getItem(int position) {
            return listProduct.get(position);
        }

        @Override
        public long getItemId(int position) {
            return listProduct.get(position).productID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
            } else viewProduct = convertView;

            Product product = (Product) getItem(position);
            ((TextView) viewProduct.findViewById(R.id.idproduct)).setText(String.format("ID = %d", product.productID));
            ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Tên SP : %s", product.name));
            ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Giá %d", product.price));


            return viewProduct;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void button_clicked_2(View view) {
        Context Context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Context);
        builder1.setMessage("8h mở cửa, 22h đóng cửa.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Đồng Ý",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void new_sp() {
        Context Context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Context);
        builder1.setMessage("Sản phẩm mới:\nQuạt điều hoà Delites RPD-30\nMận đỏ C&D Chile\nĐÈN LED PANEL TẤM MPE SERIES FPL ÁNH SÁNG TRẮNG/ TRUNG TÍNH/ VÀNG");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Đồng Ý",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void km() {
        Context Context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Context);
        builder1.setMessage("Xin lỗi, hiện tại chưa có chương trình khuyến mãi nào.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Đồng Ý",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void button_clicked_3(View view) {
        Context context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Chọn thông tin thông báo:");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Sản Phẩm Mới",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        new_sp();
                    }
                });

        builder1.setNegativeButton(
                "Khuyến Mãi",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        km();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void button_clicked_4(View view) {
        TextView textView3_changer = (TextView)findViewById(R.id.textView3);

        textView3_changer.setText("Điện Máy Gia Dụng");

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Bình đun siêu tốc Delites 1.8 lít ST18S05", 169000));
        listProduct.add(new Product(2, "Máy xay sinh tố đa năng Philips HR2041/10 - 2 cối", 590000));
        listProduct.add(new Product(3, "Nồi chiên không dầu Rapido RAF-8.0M 8 lít", 1590000));
        listProduct.add(new Product(4, "Quạt điều hoà Delites RPD-30", 169000));
        listProduct.add(new Product(5, "Máy lọc nước RO nóng nguội lạnh Karofi KAD-X39 10 lõi", 6990000));

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);
    }


    public void button_clicked_5(View view) {
        TextView textView3_changer = (TextView)findViewById(R.id.textView3);

        textView3_changer.setText("Thực Phẩm");

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Táo đỏ Fuji Nhật Bản", 89500));
        listProduct.add(new Product(2, "Hồng táo Royal Jujube Úc - 500G (I0015240)", 140000));
        listProduct.add(new Product(3, "Nho xanh Sweet Globe Úc - 500G", 79500));
        listProduct.add(new Product(4, "Dâu Hàn Quốc 250G", 139000));
        listProduct.add(new Product(5, "Mận đỏ C&D Chile", 129500));

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);
    }

    public void button_clicked_6(View view) {
        TextView textView3_changer = (TextView)findViewById(R.id.textView3);

        textView3_changer.setText("Thiết Bị Điện");

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "ĐÈN LED BÁN NGUYỆT MPE SERIES BN2 ÁNH SÁNG TRẮNG/ VÀNG", 109450));
        listProduct.add(new Product(2, "ĐÈN LED PANEL TẤM MPE SERIES FPL ÁNH SÁNG TRẮNG/ TRUNG TÍNH/ VÀNG", 383250));
        listProduct.add(new Product(3, "ĐÈN SẠC CHIẾU SÁNG KHẨN CẤP KENTOM KT 2200EL", 290000));
        listProduct.add(new Product(4, "ĐÈN PHA LED NĂNG LƯỢNG MẶT TRỜI ANFACO SOLAR 009", 1248750));
        listProduct.add(new Product(5, "LED PANEL ÂM TRẦN ANFACO AFC 668 9W\n", 145600));

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);
    }

    public void button_clicked_9(View view) {
        TextView textView3_changer = (TextView)findViewById(R.id.textView3);

        textView3_changer.setText("Tốt Nhất Thị Trường");

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "ĐÈN LED BÁN NGUYỆT MPE SERIES BN2 ÁNH SÁNG TRẮNG/ VÀNG", 109450));
        listProduct.add(new Product(2, "Táo đỏ Fuji Nhật Bản", 89500));
        listProduct.add(new Product(3, "Bình đun siêu tốc Delites 1.8 lít ST18S05", 169000));

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);
    }

    public void button_clicked_10(View view) {
        Context Context = this;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Context);
        builder1.setMessage("Tháng này: 0 sản phẩm.\nNăm này: 0 sản phẩm.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Đóng",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void initQRCodeScanner() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        integrator.setOrientationLocked(true);
        integrator.setPrompt("Quét mã");
        integrator.initiateScan();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initQRCodeScanner();
            } else {
                Toast.makeText(this, "Yêu cầu quyền truy cập camera để quét mã", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Đã hủy quét", Toast.LENGTH_LONG).show();
            } else {
                Context Context = this;
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Context);
                builder1.setMessage("Code: " +  result.getContents());
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Đồng Ý",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void image_button_clicked_4(View view) {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
        } else {
            initQRCodeScanner();
        }
    }
}