package com.example.mynicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

/**
 * Esta es la pantalla principal de la aplicacion. Cuando haces login correctamente te lleva ha esta pantalla.
 *
 * @author Pablo Benito
 * @see MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ImageView img_perfil;
    private SwipeRefreshLayout swipeLayout;
    private ExpandableCardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_pasar);
        img_perfil = findViewById(R.id.img_perfil);
        card = findViewById(R.id.profile);

        registerForContextMenu(img_perfil);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                        "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(this)
                .load(R.drawable.chica_guay)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop()
                .into(img_perfil);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity
                        .this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.camera:
                Toast toast = Toast.makeText(this, "EDITANDO....", Toast.LENGTH_LONG);
                toast.show();
                //Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                //startActivity(intent);
                break;
            case R.id.action_settings:
                Toast toast2 = Toast.makeText(this, "BORRANDO....", Toast.LENGTH_LONG);
                toast2.show();
                // Intent intent2 = new Intent(MainActivity.this, AnyChartActivity.class);
                //startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }


    public void openScrolling(View view) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "DELETING", Toast.LENGTH_LONG);
            toast.show();
            showAlertDialogButtonClicked(MainActivity.this);

        } else if (id == R.id.camera) {
            Toast toast = Toast.makeText(this, "EDITING", Toast.LENGTH_LONG);
            toast.show();

        }

        return super.onOptionsItemSelected(item);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };

    public void showAlertDialogButtonClicked(MainActivity view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
                null));

        builder.setPositiveButton("Glide", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("ChatBot", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton("MotionLayout", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}