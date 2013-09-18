package ubs.core.actions;

import ubs.core.Reservation;
import ubs.core.ReservationStatus;

public class StatusChangeAction implements Action {

	private ReservationStatus status;
	private Reservation reservation;
	
	public StatusChangeAction(ReservationStatus status) {
		this.status = status;
	}

	@Override
	public void execute() throws Exception {
		if (reservation == null) throw new Exception("Reservation not set!");
		reservation.setStatus(status);
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}