package models;

public class ResponseType {
	private String message;
	private String type;

	public ResponseType(final String _message, final String _type) {
		this.message = _message;
		this.type = _type;
	}

	public static ResponseType success(final String _message) {
		return new ResponseType(_message, "success");
	}

	public static ResponseType error(final String _message) {
		return new ResponseType(_message, "error");
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}
}
