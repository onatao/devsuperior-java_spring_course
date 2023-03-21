package ReservationEx.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import ReservationEx.model.exception.DomainException;

public class Reservation {
	
	private static SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	
	
	
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		// Calcular a dif entre datas retornado em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// Conversão de ms para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut) throws DomainException{
		Date now = new Date();
		if (checkIn.before(now) || (checkOut.before(now))) {
			throw new DomainException("Error");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + + roomNumber + ", check-in " + spdf.format(checkIn) 
		+ " , check-out " + spdf.format(checkOut) + ", " + duration() + " nights.";
	}
	
}
