import { defineStore } from 'pinia';
import axios from 'axios';

// interface BookingTime {
//     id: number;
//     startdate: string;
//     enddate: string;
// }

export const useBookingStore = defineStore('bookingStore', {
    state: () => ({
        response: null as number | null,
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

            } catch (error) {
                console.error('Error checking availability:', error);
                //this.reponse already null
            }
        },
    },
});
