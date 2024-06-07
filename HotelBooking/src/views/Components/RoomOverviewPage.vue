<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateToWelcome">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <ion-title slot="end">Room Overview</ion-title>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <h1>Our Rooms</h1>
            <RoomList :rooms="rooms" :paginatedRooms="paginatedRooms" :selectedRoomId="selectedRoomId"
                @selectRoom="selectRoom" />
            <div class="availability-button-container">
                <ion-button color="mygreen" @click="checkAvailability" class="availability-button">Check
                    Availability</ion-button>
            </div>
            <div class="pagination-container">
                <ion-button @click="prevPage" :disabled="currentPage === 1">Previous</ion-button>
                <ion-button @click="nextPage" :disabled="currentPage === totalPages">Next</ion-button>
            </div>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import axios from 'axios';
import RoomList from '../Models/RoomListModel.vue'

interface Room {
    id: number;
    title: string;
    description: string;
    extras: string[];
}

export default {
    name: 'RoomOverviewPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonIcon,
        RoomList
    },
    data() {
        return {
            rooms: [] as Room[],
            currentPage: 1,
            roomsPerPage: 5,
            selectedRoomId: null as number | null,
        };
    },
    computed: {
        totalPages() {
            return Math.ceil(this.rooms.length / this.roomsPerPage);
        },
        paginatedRooms() {
            const start = (this.currentPage - 1) * this.roomsPerPage;
            const end = start + this.roomsPerPage;
            return this.rooms.slice(start, end);
        },
    },
    mounted() {
        this.fetchRooms();
    },
    setup() {
        return {
            arrowBackOutline
        };
    },
    methods: {
        async fetchRooms() {
            try {
                const response = await axios.get('http://127.0.0.1:8080/api/v1/rooms');
                if (response.data && response.data.rooms && response.data.rooms.length > 0) {
                    this.rooms = response.data.rooms.map((room: any) => ({
                        id: room.roomid,
                        title: room.title,
                        description: room.description,
                        extras: room.extras || [],
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
            ] as Room[];
        },
        navigateToWelcome() {
            this.$router.push('/');
        },
        nextPage() {
            if (this.currentPage < this.totalPages) {
                this.currentPage++;
            }
        },
        prevPage() {
            if (this.currentPage > 1) {
                this.currentPage--;
            }
        },
        selectRoom(roomId: number) {
            this.selectedRoomId = roomId;
        },
        checkAvailability() {
            alert(this.selectedRoomId)
        },
    }
};
</script>

<style scoped>
.pagination-container {
    margin-top: 50px;
    display: flex;
    justify-content: center;
}

.availability-button-container {
    margin-top: 20px;
    display: flex;
    justify-content: center;
}

.availability-button {
    width: 20em;
    font-size: 1.2em;
}
</style>
