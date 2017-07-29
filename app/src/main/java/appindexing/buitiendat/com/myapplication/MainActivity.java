package appindexing.buitiendat.com.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indexRecipe();
    }

    private void indexRecipe() {
        Indexable recipeToIndex = new Indexable.Builder()
                .setName("dattien")
                .setUrl("https://framgia.com")
                .build();
        Task<Void> task = FirebaseAppIndex.getInstance().update(recipeToIndex);
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.e("DAT", "App Indexing API: Successfully");
            }
        });

        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e("DAT", "App Indexing API: Failed ");
            }
        });
    }
}
