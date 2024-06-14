import { defineStore } from 'pinia';
import axios from 'axios';

interface Room {
    id: number;
    title: string;
    description: string;
    extras: string[];
}

export const useRoomStore = defineStore('roomStore', {
    state: () => ({
        rooms: [] as Room[],
    }),
    actions: {
        async fetchRooms() {
            try {
                const response = await axios.get('http://127.0.0.1:8080/api/v1/rooms');
                if (response.data && response.data.rooms && response.data.rooms.length > 0) {
                    this.rooms = response.data.rooms.map((room: any) => ({
                        id: room.roomid,
                        title: room.roomTitle,
                        description: room.roomDescription,
                        extras: room.roomExtras.map((extra: any) => extra.extraName),
                    }));
                } else {
                    this.setDefaultRoom();
                }
            } catch (error) {
                console.error('Error fetching rooms:', error);
                this.setDefaultRoom();
            }
        },
        setDefaultRoom() {
            this.rooms = [
                {
                    id: 0,
                    title: 'Default Room',
                    description: 'This is a default room description. This room is provided as an example in case the API call fails or returns no data.',
                    extras: ['Free WiFi', 'Air Conditioning', 'Mini Bar'],
                },
            ];
        },
    },
});
