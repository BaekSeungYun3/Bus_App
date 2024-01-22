package com.example.bus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteActivity extends AppCompatActivity {

    //알림장 작성
        EditText tilteEditText,contentEditText;
        ImageButton saveNoteBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_note);

            tilteEditText=findViewById(R.id.notes_title_text);
            contentEditText=findViewById(R.id.notes_content_text);
            saveNoteBtn=findViewById(R.id.save_note_btn);
            saveNoteBtn.setOnClickListener((v)->saveNote());
        }
        void saveNote(){
            String noteTitle=tilteEditText.getText().toString();
            String noteContent = contentEditText.getText().toString();
            if(noteTitle==null ||noteTitle.isEmpty()){
                tilteEditText.setError(("제목을 작성하세요."));
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
            documentReference = Utility.TgetCollwctionReferenceForNotes().document();

            documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        //note is add
                        Utility.showToast(NoteActivity.this, "알림장 저장에 성공했습니다!");
                        finish();
                    }else{
                        Utility.showToast(NoteActivity.this, "알림장 저장에 실패했습니다.");
                    }
                }
            });
        }
    }