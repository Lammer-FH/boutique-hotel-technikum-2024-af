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
            <RoomList :paginatedRooms="paginatedRooms" :selectedRoomId="selectedRoomId" @selectRoom="selectRoom" />
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
import RoomList from '../Models/RoomListModel.vue';
import { useRoomStore } from '../Stores/RoomStore'

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
        RoomList,
    },
    data() {
        return {
            currentPage: 1,
            roomsPerPage: 5,
            selectedRoomId: null as number | null,
        };
    },
    computed: {
        totalPages() {
            const roomStore = useRoomStore();
            return Math.ceil(roomStore.rooms.length / this.roomsPerPage);
        },
        paginatedRooms() {
            const roomStore = useRoomStore();
            const start = (this.currentPage - 1) * this.roomsPerPage;
            const end = start + this.roomsPerPage;
            return roomStore.rooms.slice(start, end);
        },
    },
    mounted() {
        this.fetchRooms();
    },
    setup() {
        return {
            arrowBackOutline,
        };
    },
    methods: {
        async fetchRooms() {
            const roomStore = useRoomStore();
            await roomStore.fetchRooms();
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
            alert(this.selectedRoomId);
        },
    },
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
