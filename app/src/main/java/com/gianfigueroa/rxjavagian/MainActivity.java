package com.gianfigueroa.rxjavagian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.gianfigueroa.rxjavagian.clases.Blog;
import com.gianfigueroa.rxjavagian.clases.BlogObservable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    public String TAG=this.getClass().getSimpleName();
    private Observable<Blog> blog$;
    private BlogObservable blogObservable;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editext);
        final Blog blog=new Blog();
        blogObservable=new BlogObservable(blog);
        blog$=blogObservable;
        blog$.subscribe(new Observer<Blog>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Blog blog) {
                Log.d(TAG, "onNext: "+blog.getTitle());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                blog.setTitle(charSequence+"");
                blogObservable.changeBlog();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}
