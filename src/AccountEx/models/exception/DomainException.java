package AccountEx.models.exception;

public class DomainException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DomainException(String errorMsg) {
		super(errorMsg);
	}

}
