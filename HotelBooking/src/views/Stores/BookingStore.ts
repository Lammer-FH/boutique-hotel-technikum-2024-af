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
        async submitReservation(name: string, surname: string, email: string, breakfast: boolean) {
            try {
                const response = await axios.post('http://127.0.0.1:8080/api/v1/bookings', {
                    id: this.bookingTime?.id,
                    arrivalDate: this.bookingTime?.arrivalDate,
                    departureDate: this.bookingTime?.departureDate,
                    name,
                    surname,
                    email,
                    breakfast
                });
                
                this.response = response.status;

                //implement successfull check later
                this.reservation =
                {
                        name: name,
                        surname: surname,
                        email: email,
                        breakfast: breakfast
                }

            } catch (error) {
                console.error('Error checking availability:', error);
                //this.reponse already null
            }
        },
    },
});
