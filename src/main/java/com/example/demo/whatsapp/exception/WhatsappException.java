package com.example.demo.whatsapp.exception;

public class WhatsappException extends Exception {

	private static final long serialVersionUID = -2093312986951988270L;

	private String message;

	/**
	 * Construtor da classe.
	 *
	 * @param e
	 */
	public WhatsappException(Throwable e) {
		String msg = e.getMessage();
		if (msg != null) {
			if (msg.contains(": \"")) {
				msg = msg.split(": \"")[1];
				msg = msg.substring(0,msg.length());
			}
		}
		this.setMessage(msg);
	}

	public WhatsappException(String msg){
        this.setMessage(msg);
    }

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message vo set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}