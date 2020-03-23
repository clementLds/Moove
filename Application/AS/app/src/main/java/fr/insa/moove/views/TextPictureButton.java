package fr.insa.moove.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.insa.moove.R;

public class TextPictureButton extends LinearLayout {

    ImageView imageView;
    TextView textView;

    public TextPictureButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.activity_menu, this);

        //On récupère les valeurs
        imageView = findViewById(R.id.imageTextPictureButton);
        textView = findViewById(R.id.captionTextPictureButton);

        //Charger tous les attributs
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextPictureButton);
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.TextPictureButton_image));
        textView.setText(attributes.getString(R.styleable.TextPictureButton_text));
        //Indispensable visiblement
        attributes.recycle();

    }

}