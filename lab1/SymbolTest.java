import java.io.*;

public class SymbolTest {

	public static void main(final String[] args) throws IOException {

		SymbolTable st = new SymbolTable();

        System.out.println("Putting 8 key-value pairs into the SymbolTable");
        st.put("Christ", 't');
        st.put("Moe", 'm');
        st.put("Alich", 'a');
        st.put("Typo", 'z');
        st.put("Hell", 'h');
        st.put("Broke", 'b');
        st.put("Billy", 'y');
		st.put("None", 'n');
        st.dump();
        
        System.out.println("Size should be 7. Size is : " + st.size());

        System.out.println("Deleting one key-value pair");
        
        st.delete("Typo");

        st.dump();

        System.out.println("Size should be 6, size is: " + st.size());

        System.out.println("Trying to remove alich");

        st.delete("Alich");
        System.out.println("trying to put key with char null");
        st.put("Hell", null);
        st.dump();


	}
}
