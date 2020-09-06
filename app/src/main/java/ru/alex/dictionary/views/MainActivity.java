package ru.alex.dictionary.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import ru.alex.dictionary.R;
import ru.alex.dictionary.adapters.RecyclerViewMainAdapter;
import ru.alex.dictionary.contractors.MainContractor;
import ru.alex.dictionary.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContractor.View, TextWatcher {

    private MainContractor.Presenter mPresenter;

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private TextInputEditText etSearch;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        init();
        setTheme();
    }

    private void setTheme() {
        sharedPreferences = getSharedPreferences(SettingsActivity.SETTINGS, MODE_PRIVATE);
        switch (sharedPreferences.getInt(SettingsActivity.THEME_ID, 0)) {
            case 0:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                setTheme(R.style.AppTheme);
                break;
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                setTheme(R.style.AppThemeRed);
                break;
        }
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true);
        getWindow().getDecorView().setBackgroundColor(typedValue.data);
        theme.resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(typedValue.data));
        theme.resolveAttribute(android.R.attr.colorPrimaryDark, typedValue, true);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(typedValue.data);
    }

    private void init() {
        drawerLayout = findViewById(R.id.dl_main);
        toolbar = findViewById(R.id.toolbar);
        initToolbar();
        recyclerView = findViewById(R.id.rvMain);
        initRV();
        etSearch = findViewById(R.id.et_search);
        etSearch.addTextChangedListener(this);
    }

    private void initRV() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @SuppressLint("RestrictedApi")
    private void initToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dictionary:
                        break;
                    case R.id.settings:
                        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                        finish();
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        mPresenter.loadWords(sharedPreferences.getString(SettingsActivity.API_ID, SettingsActivity.DEFAULT_API_ID),
                sharedPreferences.getString(SettingsActivity.API_KEY, SettingsActivity.DEFAULT_API_KEY),
                Objects.requireNonNull(etSearch.getText()).toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void updateRV(RecyclerViewMainAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showToast(String word) {
        Toast.makeText(this, word, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSnackbar(String message) {
        Snackbar.make(drawerLayout, message, Snackbar.LENGTH_LONG).setTextColor(Color.WHITE).show();
    }
}