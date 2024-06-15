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

export const useBookingStore = defineStore('bookingStore', {
    state: () => ({
        response: null as number | null,
        bookingTime: null as BookingTime | null,
        reservation: null as Reservation | null,
    }),
    actions: {
        async checkAvailability(id: number, arrivalDate: string, departureDate: string) {
            try {
                const response = await axios.post('http://127.0.0.1:8080/api/v1/bookings', {
                    id,
                    arrivalDate,
                    departureDate
                });
                
                this.response = response.status;

                //implement successfull check later
                this.bookingTime = 
                {
                    id: id,
                    arrivalDate: arrivalDate,
                    departureDate: departureDate
                }

            } catch (error) {
                console.error('Error checking availability:', error);
                //this.reponse already null
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
                    id: this.bookingTime?.id,
                    arrivalDate: this.bookingTime?.arrivalDate,
                    departureDate: this.bookingTime?.departureDate,
                    name: this.reservation?.name,
                    surname: this.reservation?.surname,
                    email: this.reservation?.email,
                    breakfast: this.reservation?.breakfast,
                });
                
                this.response = response.status;

            } catch (error) {
                console.error('Error checking availability:', error);
                //this.reponse already null
            }
        },
    },
});
