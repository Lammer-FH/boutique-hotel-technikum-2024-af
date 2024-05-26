<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-title slot="end">Room Overview</ion-title>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <h1>Our Rooms</h1>
            <ion-list>
                <ion-item v-for="(room, index) in paginatedRooms" :key="room.id" @click="selectRoom(room.id)">
                    <img :src="getImagePath(index)" alt="Room Image" class="room-image" />
                    <ion-checkbox slot="start" :checked="selectedRoomId === room.id">
                    </ion-checkbox>
                    <ion-label>
                        <h3>{{ room.title }}</h3>
                        <p>{{ room.description }}</p>
                        <ul class="extras-list">
                            <li v-for="extra in room.extras" :key="extra" class="extra-item">
                                <ion-icon :icon="getIcon(extra)"></ion-icon>
                                {{ extra }}
                            </li>
                        </ul>
                    </ion-label>
                </ion-item>
            </ion-list>
            <div class="pagination-container">
                <ion-button @click="prevPage" :disabled="currentPage === 1">Previous</ion-button>
                <ion-button @click="nextPage" :disabled="currentPage === totalPages">Next</ion-button>
            </div>
            <ion-button class="return-button" @click="navigateToWelcome">Return</ion-button>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonList, IonItem, IonLabel, IonIcon, IonButton, IonCheckbox } from '@ionic/vue';
import { wifiOutline, snowOutline, wineOutline, volumeMuteOutline, tvOutline, checkmarkCircleOutline } from 'ionicons/icons';
import axios from 'axios';

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
        IonList,
        IonItem,
        IonLabel,
        IonButton,
        IonIcon,
        IonCheckbox
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
    methods: {
        async fetchRooms() {
            try {
                const response = await axios.get('https://your-backend-api-url/rooms');
                if (response.data && response.data.length > 0) {
                    this.rooms = response.data;
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
                    description:
                        'This is a default room description. This room is provided as an example in case the API call fails or returns no data.',
                    extras: ['Free WiFi', 'Air Conditioning', 'Mini Bar'],
                },
                {
                    id: 1,
                    title: 'Deluxe Room',
                    description: 'A spacious room with deluxe amenities and a beautiful view.',
                    extras: ['TV', 'Air Conditioning', 'Mini Bar'],
                },
                {
                    id: 2,
                    title: 'Suite Room',
                    description: 'An elegant suite with separate living area and luxury features.',
                    extras: ['Free WiFi', 'Mini Bar', 'Noise Protection'],
                },
                {
                    id: 3,
                    title: 'Standard Room',
                    description: 'A comfortable standard room with essential amenities.',
                    extras: ['Free WiFi', 'TV', 'Air Conditioning'],
                },
                {
                    id: 4,
                    title: 'Family Room',
                    description: 'A spacious room perfect for families, with additional sleeping arrangements.',
                    extras: ['TV', 'Mini Bar', 'Noise Protection'],
                },
                {
                    id: 5,
                    title: 'Executive Room',
                    description: 'A premium room with executive amenities and a work area.',
                    extras: ['Free WiFi', 'Air Conditioning', 'TV'],
                },
            ] as Room[];
        },
        navigateToWelcome() {
            this.$router.push('/');
        },
        getIcon(extra: string) {
            switch (extra.toLowerCase()) {
                case 'free wifi':
                    return wifiOutline;
                case 'air conditioning':
                    return snowOutline;
                case 'mini bar':
                    return wineOutline;
                case 'noise protection':
                    return volumeMuteOutline;
                case 'tv':
                    return tvOutline;
                default:
                    return checkmarkCircleOutline;
            }
        },
        getImagePath(index: number) {
            return `/Rooms/room${index + 1}.jpg`;
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
    }
};
</script>

<style scoped>
.pagination-container {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.return-button {
    position: fixed;
    bottom: 16px;
    right: 32px;
    z-index: 100;
}

.extras-list {
    list-style-type: none;
    padding: 0;
}

.extra-item {
    display: flex;
    align-items: center;
}

.extra-item ion-icon {
    margin-right: 8px;
}

.room-image {
    width: 100px;
    height: auto;
    margin-right: 10px;
}
</style>