<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle slot="end">Reservation Confirmation</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <h1>Your stay</h1>
            <ion-row style="border-bottom: ridge;">
                <ion-col size="4">
                    <ion-label>Room</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>{{ roomTitle }}</ion-label>
                </ion-col>
            </ion-row>
            <ion-row style="border-bottom: ridge;">
                <ion-col size="4">
                    <ion-label>Description</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>{{ roomDescription }}</ion-label>
                </ion-col>
            </ion-row>
            <ion-row style="border-bottom: ridge;">
                <ion-col size="4">
                    <ion-label>Details</ion-label>
                </ion-col>
                <ion-col size="4">
                    <ion-label><img :src="getImagePath(roomID)" alt="Room Image" class="room-image" /></ion-label>
                </ion-col>
                <ion-col size="4">
                    <ion-label>
                        <ExtrasList :extras=roomExtras />
                    </ion-label>
                </ion-col>
            </ion-row>
            <ion-row style="border-bottom: ridge;">
                <ion-col size="4">
                    <ion-label>Timeframe</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>{{ reformatDate(arrivalDate) }} till {{ reformatDate(departureDate) }}</ion-label>
                </ion-col>
            </ion-row>
            <ion-row>
                <ion-col size="4">
                    <ion-label>Breakfast</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>{{ breakfastStatus }}</ion-label>
                </ion-col>
            </ion-row>
            <br>
            <h1>Your data</h1>
            <ion-row style="border-bottom: ridge;">
                <ion-col size="4">
                    <ion-label>Full Name</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>{{ name }} {{ surname }}</ion-label>
                </ion-col>
            </ion-row>
            <ion-row>
                <ion-col size="4">
                    <ion-label>Email</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>{{ email }}</ion-label>
                </ion-col>
            </ion-row>
            <br>
            <h1>Contact us</h1>
            <ion-row style="border-bottom: ridge;">
                <ion-col size="4">
                    <ion-label>Email / Number</ion-label>
                </ion-col>
                <ion-col size="8">
                    <ion-label>info@luxorahotel.com / +123-456-7890</ion-label>
                </ion-col>
                <ion-col size="12">
                    <h1>How to reach us:</h1>
                    <img src="/DriveImage/drive.jpg" alt="Drive Image" class="drive-image" />
                </ion-col>
            </ion-row>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon, IonLabel } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import { useBookingStore } from '../Stores/BookingStore'
import { useRoomStore } from '../Stores/RoomStore'
import ExtrasList from '../Models/ExtrasListModel.vue'

export default {
    name: 'BookingReservationConfirmationPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonIcon,
        IonLabel,
        ExtrasList,
    },
    data() {
        return {
            bookingStore: null as any,
            roomStore: null as any,
            arrowBackOutline
        };
    },
    created() {
        this.bookingStore = useBookingStore();
        this.roomStore = useRoomStore();
    },
    computed: {
        name() {
            return this.bookingStore.reservation?.name;
        },
        surname() {
            return this.bookingStore.reservation?.surname;
        },
        email() {
            return this.bookingStore.reservation?.email;
        },
        breakfast() {
            return this.bookingStore.reservation?.breakfast;
        },
        breakfastStatus() {
            return this.breakfast === true ? "Yes" : "No";
        },
        roomTitle() {
            return this.roomStore.currentRoom?.title;
        },
        arrivalDate() {
            return this.bookingStore.bookingTime?.arrivalDate;
        },
        departureDate() {
            return this.bookingStore.bookingTime?.departureDate;
        },
        roomDescription() {
            return this.roomStore.currentRoom?.description;
        },
        roomID() {
            return this.roomStore.currentRoom?.id;
        },
        roomExtras() {
            return this.roomStore.currentRoom?.extras;
        },
    },
    methods: {
        navigateBack() {
            this.$router.push('/');
        },
        getImagePath(index: number) {
            return `/Rooms/room${index}.jpg`;
        },
        reformatDate(date: string) {
            return date.substring(8, 10) + "." + date.substring(5, 7) + "." + date.substring(0, 4)
        }
    },
};
</script>

<style scoped>
.page-title {
    text-align: center;
    font-size: 2em;
    margin-bottom: 20px;
}

.room-image {
    width: 200px;
    height: auto;
}

.drive-image {
    width: 350px;
    height: auto;
    margin-top: 10px;
}
</style>