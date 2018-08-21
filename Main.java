
//
//
// Main.java
// 2018 @auther piteredo
// This Program is MIT license.
//
//
import java.util.Scanner;

enum Note {
  C, Cis, D, Es, E, F, Fis, G, As, A, B, H;
}

enum Chord {
  MAJOR(Note.C, Note.E, Note.G),
  MINOR(Note.C, Note.Es, Note.G),
  MAJOR_SEVENTH(Note.C, Note.E, Note.G, Note.H),
  MINOR_SEVENTH(Note.C, Note.Es, Note.G, Note.B);
  // and so on...

  private Note[] modelNotes; // key:C(=Note[0]) case

  private Chord(Note root, Note third, Note fifth){
    this.modelNotes = new Note[3];
    this.modelNotes[0] = root;
    this.modelNotes[1] = third;
    this.modelNotes[2] = fifth;
  }

  private Chord(Note root, Note third, Note fifth, Note seventh){
    this.modelNotes = new Note[4];
    this.modelNotes[0] = root;
    this.modelNotes[1] = third;
    this.modelNotes[2] = fifth;
    this.modelNotes[3] = seventh;
  }

  public Note[] getChordNotes(Note rootNote){
    Note[] chordNotes = new Note[this.modelNotes.length];
    int i = 0;
    for(Note modelNote : this.modelNotes){
      int v = (modelNote.ordinal() + rootNote.ordinal()) % Note.values().length;
      chordNotes[i] = Note.values()[v];
      i++;
    }
    return chordNotes;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("input chord type.");
    for(Chord chord : Chord.values()){
      System.out.print("(" + chord.ordinal() + ")" + chord + ", ");
    }
    System.out.println();
    int chordType = sc.nextInt();

    System.out.println("input root note.");
    for(Note note : Note.values()){
      System.out.print("(" + note.ordinal() + ")" + note + ", ");
    }
    System.out.println();
    int rootType = sc.nextInt();
    sc.close();

    Chord chord  = Chord.values()[chordType];
    Note root = Note.values()[rootType];
    System.out.print(root + "_" + chord + " chord notes are: ");
    for(Note note: chord.getChordNotes(root)){
      System.out.print(note + " ");
    }
    System.out.println();
  }
}
