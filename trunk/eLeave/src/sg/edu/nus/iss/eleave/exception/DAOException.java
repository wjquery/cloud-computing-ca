
package sg.edu.nus.iss.eleave.exception;

public class DAOException extends Exception {
	static final  long serialVersionUID = 1L;

	public DAOException() {}
    
    public DAOException(String s) {
        super(s);
    }
    
    public DAOException(Exception e) {
        super(e);
    }
}

