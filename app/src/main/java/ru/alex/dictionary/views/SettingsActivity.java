package ru.alex.dictionary.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Objects;

import ru.alex.dictionary.R;

public class SettingsActivity extends AppCompatActivity implements TextWatcher {

    public static final String SETTINGS = "settings";
    public static final String API_KEY = "apiKey";
    public static final String API_ID = "apiId";
    public static final String THEME_ID = "themeId";
    public static final String DEFAULT_API_KEY = "01f3481c06edb4df76180f7cfa5b650f";
    public static final String DEFAULT_API_ID = "4206847b";

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private MaterialEditText etAPIKey;
    private MaterialEditText etAPIId;
    private Spinner spTheme;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
        sharedPreferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        etAPIKey.setText(sharedPreferences.getString(API_KEY, DEFAULT_API_KEY));
        etAPIId.setText(sharedPreferences.getString(API_ID, DEFAULT_API_ID));
        spTheme.setSelection(sharedPreferences.getInt(THEME_ID, 0));
    }

    private void init() {
        drawerLayout = findViewById(R.id.dl_settings);
        toolbar = findViewById(R.id.toolbar_settings);
        initToolbar();
        etAPIKey = findViewById(R.id.et_api_key);
        etAPIId = findViewById(R.id.et_api_id);
        spTheme = findViewById(R.id.sp_theme);
        etAPIKey.addTextChangedListener(this);
        etAPIId.addTextChangedListener(this);
        spTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(THEME_ID, position);
                editor.apply();
                switch (position) {
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

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        NavigationView navigationView = findViewById(R.id.navigation_drawer_settings);
        navigationView.getMenu().getItem(1).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dictionary:
                        startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                        break;
                    case R.id.settings:
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
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(API_KEY, Objects.requireNonNull(etAPIKey.getText()).toString());
        editor.putString(API_KEY, Objects.requireNonNull(etAPIId.getText()).toString());
        editor.apply();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}