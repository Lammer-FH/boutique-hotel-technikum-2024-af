import { defineStore } from 'pinia';
import axios from 'axios';

interface RoomAvailability {
    roomIsAvailable: boolean;
    nextTimeAvailable: string;
}

export const useBookingStore = defineStore('bookingStore', {
    state: () => ({
        response: null as number | null,
        roomAvailability: null as RoomAvailability | null,
    }),
    actions: {
        async checkAvailability(id: number, arrivalDate: string, departureDate: string) {
            try {
                const response = await axios.get('http://127.0.0.1:8080/api/v1/bookings/', {
                    params: {
                        roomId: id,
                        startDate: arrivalDate+"T00:00:00.000Z", //add time for backend
                        endDate: departureDate+"T00:00:00.000Z"  //add time for backend
                    }
                });
                
                this.response = response.status;
                this.roomAvailability = {
                    roomIsAvailable: response.data.roomIsAvailable,
                    nextTimeAvailable: response.data.nextTimeAvailable,
                };

            } catch (error) {
                console.error('Error checking availability:', error);
                this.response = null;
            }
        },
    },
});
