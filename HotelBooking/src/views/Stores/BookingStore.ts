import { defineStore } from 'pinia';
import axios from 'axios';

interface BookingTime {
    id: number;
    arrivalDate: string;
    departureDate: string;
}

export const useBookingStore = defineStore('bookingStore', {
    state: () => ({
        response: null as number | null,
        bookingTime: [] as BookingTime[],
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
                this.bookingTime = [
                    {
                        id: id,
                        arrivalDate: arrivalDate,
                        departureDate: departureDate
                    },
                ];

            } catch (error) {
                console.error('Error checking availability:', error);
                //this.reponse already null
            }
        },
    },
});
