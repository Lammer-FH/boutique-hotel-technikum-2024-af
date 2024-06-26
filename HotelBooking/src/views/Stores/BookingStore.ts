import { defineStore } from 'pinia';
import axios from 'axios';

interface BookingTime {
    id: number;
    arrivalDate: string;
    departureDate: string;
}

interface Reservation {
    name: string;
    surname: string;
    email: string;
    breakfast: boolean;
}

interface RoomAvailability {
    roomIsAvailable: boolean;
    nextTimeAvailable: string;
}

export const useBookingStore = defineStore('bookingStore', {
    state: () => ({
        response: null as number | null,
        bookingTime: null as BookingTime | null,
        reservation: null as Reservation | null,
        roomAvailability: null as RoomAvailability | null,
    }),
    actions: {
        async checkAvailability(id: number, arrivalDate: string, departureDate: string) {
            try {
                const response = await axios.get('http://127.0.0.1:8080/api/v1/bookings/', {
                    params: {
                        roomId: id,
                        startDate: arrivalDate + "T00:00:00.000Z", //add time for backend
                        endDate: departureDate + "T00:00:00.000Z"  //add time for backend
                    }
                });
                this.response = response.status;
                this.roomAvailability = {
                    roomIsAvailable: response.data.roomIsAvailable,
                    nextTimeAvailable: response.data.nextTimeAvailable,
                };
                if (this.roomAvailability.roomIsAvailable === true) {
                    this.bookingTime =
                    {
                        id: id,
                        arrivalDate: arrivalDate,
                        departureDate: departureDate
                    }
                }
            } catch (error) {
                console.error('Error checking availability:', error);
            }
        },
        setReservation(name: string, surname: string, email: string, breakfast: boolean) {
            this.reservation =
            {
                name: name,
                surname: surname,
                email: email,
                breakfast: breakfast
            }
        },
        async submitReservation() {
            try {
                const response = await axios.post('http://127.0.0.1:8080/api/v1/bookings', {
                    room: {
                        roomId: this.bookingTime?.id
                    },
                    guest: {
                        guestEmail: this.reservation?.email,
                        guestName: this.reservation?.name,
                        guestSurname: this.reservation?.surname,
                    },
                    bookingStartTime: this.bookingTime?.arrivalDate + "T00:00:00.000Z", //add time for backend,
                    bookingEndTime: this.bookingTime?.departureDate + "T00:00:00.000Z", //add time for backend,
                    breakfast: this.reservation?.breakfast
                });
                this.response = response.status;
            } catch (error) {
                console.error('Error checking availability:', error);
                this.response = null;
            }
        },
    },
});
