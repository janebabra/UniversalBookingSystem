package ubs.model;

public class StatusChangeAction implements Action {

	private ReservationStatus status;
	
	public StatusChangeAction(ReservationStatus status) {
		this.status = status;
	}

	@Override
	public void execute(BookingSystem system, Reservation reservation) {
		reservation.setStatus(status);
	}

}