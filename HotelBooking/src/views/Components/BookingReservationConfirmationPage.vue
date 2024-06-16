<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle slot="end">Reservation Check</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <div class="form-container">
                <h1 class="page-title">Check Reservation data?</h1>
                <form @submit.prevent="confirmReservation" class="reservation-form">
                    <IonItem class="form-item">
                        <IonLabel position="floating">Name</IonLabel>
                        <IonInput type="text" v-model="name" required disabled></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Surname</IonLabel>
                        <IonInput type="text" v-model="surname" required disabled></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Email</IonLabel>
                        <IonInput type="email" v-model="email" required disabled></IonInput>
                    </IonItem>
                    <IonItem>
                        <IonLabel>Breakfast</IonLabel>
                        <IonToggle v-model="breakfast" disabled></IonToggle>
                        <IonLabel>{{ breakfastStatus }}</IonLabel>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Room</IonLabel>
                        <IonInput type="text" v-model="roomTitle" required disabled></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Departure Date</IonLabel>
                        <IonInput type="date" v-model="departureDate" required disabled></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Arrival Date</IonLabel>
                        <IonInput type="date" v-model="arrivalDate" required disabled></IonInput>
                    </IonItem>
                    <div class="reservation-button-container">
                        <ion-button type="submit" color="mygreen" class="reservation-button">Confirm reservation</ion-button>
                    </div>
                </form>
            </div>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon, IonItem, IonLabel, IonInput, alertController, IonToggle } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import { defineComponent } from 'vue';
import { useBookingStore } from '../Stores/BookingStore'
import { useRoomStore } from '../Stores/RoomStore'

export default defineComponent({
    name: 'BookingReservationConfirmationPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonIcon,
        IonItem,
        IonLabel,
        IonInput,
        IonToggle,
    },
    data() {
        return {
            bookingStore: null as any,
            roomStore: null as any
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
    },
    setup() {
        return {
            arrowBackOutline,
        };
    },
    methods: {
        navigateBack() {
            this.$router.back();
        },
        async confirmReservation() {


            await this.bookingStore.submitReservation();

            if(this.bookingStore.response === 200)
            {
                this.errorAlert("Buchung bestätigt", "Die Buchung wurde bestätigt");
            }
            else
            {
                this.errorAlert("Unknown error", "The request could not be completed. Please try again later. If the error persists, please contact us under info@luxorahotel.com");
            }
        },
        async errorAlert(header: string, message: string) {
            const alert = await alertController.create({
            header: header,
            message: message,
            buttons: ['OK'],
            });

            await alert.present();
        },
    },
});
</script>

<style scoped>
.page-title {
    text-align: center;
    font-size: 2em;
    margin-bottom: 20px;
}

.form-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100%;
}

.reservation-form {
    width: 100%;
    max-width: 500px;
    padding: 20px;
    background: var(--ion-color-light);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.form-item {
    --highlight-height: 2px;
    --highlight-color-focused: var(--ion-color-primary);
    --inner-padding-top: 10px;
    --padding-bottom: 10px;
}

.form-item ion-label {
    margin-bottom: 10px;
}

.reservation-button-container {
    display: flex;
    justify-content: center;
}

.reservation-button {
    width: 100%;
    max-width: 20em;
    font-size: 1.2em;
}

ion-input {
    --padding-start: 8px;
    font-size: 1.2em;
}

ion-label {
    --color: var(--ion-color-primary);
    font-size: 1.2em;
}

ion-button {
    --background: var(--ion-color-primary);
    --background-hover: var(--ion-color-primary-shade);
    --background-activated: var(--ion-color-primary-tint);
    --border-radius: 8px;
    --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

@media (max-width: 767px) {
    .reservation-form {
        width: 100%;
        max-width: 100%;
        padding: 10px;
    }

    .reservation-button {
        font-size: 1em;
    }
}

ion-toggle {
  zoom: 1.2;
}

</style>
