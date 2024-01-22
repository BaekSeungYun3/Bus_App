package com.example.bus_app;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class RequestActivity extends AppCompatActivity {

    EditText PtilteEditText,PcontentEditText;
    ImageButton PsaveNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        PtilteEditText=findViewById(R.id.Pnotes_title_text);
        PcontentEditText=findViewById(R.id.Pnotes_content_text);
        PsaveNoteBtn=findViewById(R.id.Psave_note_btn);
        PsaveNoteBtn.setOnClickListener((v)->saveNote());
    }
    void saveNote(){
        String noteTitle=PtilteEditText.getText().toString();
        String noteContent = PcontentEditText.getText().toString();
        if(noteTitle==null ||noteTitle.isEmpty()){
            PtilteEditText.setError(("제목을 작성하세요."));
            return;
        }
        Note note= new Note();
        note.setTitle(noteTitle);
        note.setContent(noteContent);
        note.setTimestamp(Timestamp.now());
        saveNoteToFirebase(note);
    }
    void saveNoteToFirebase(Note note){
        DocumentReference documentReference;
        documentReference = Utility.PgetCollwctionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //note is add
                    Utility.showToast(RequestActivity.this, "요청사항 저장에 성공했습니다!");
                    finish();
                }else{
                    Utility.showToast(RequestActivity.this, "요청사항 저장에 실패했습니다.");
                }
            }
        });
    }
}