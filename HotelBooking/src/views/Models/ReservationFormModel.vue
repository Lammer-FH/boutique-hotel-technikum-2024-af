<template>
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
            <IonLabel position="floating">Arrival Date</IonLabel>
            <IonInput type="date" v-model="arrivalDate" required disabled></IonInput>
        </IonItem>
        <IonItem class="form-item">
            <IonLabel position="floating">Departure Date</IonLabel>
            <IonInput type="date" v-model="departureDate" required disabled></IonInput>
        </IonItem>
        <div class="reservation-button-container">
            <ion-button type="submit" color="mygreen" class="reservation-button">Confirm reservation</ion-button>
        </div>
    </form>
</template>

<script lang="ts">
import { IonItem, IonLabel, IonInput, IonToggle, alertController } from '@ionic/vue';
import { useBookingStore } from '../Stores/BookingStore';
import { useRoomStore } from '../Stores/RoomStore';

export default {
    name: 'ReservationForm',
    components: {
        IonItem,
        IonLabel,
        IonInput,
        IonToggle,
    },
    data() {
        return {
            bookingStore: useBookingStore(),
            roomStore: useRoomStore(),
        };
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
            return this.breakfast ? "Yes" : "No";
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
    methods: {
        async confirmReservation() {
            await this.bookingStore.submitReservation();
            if (this.bookingStore.response === 201) {
                this.$router.push({ name: 'BookingReservationConfirmation' });
            } else if (this.bookingStore.response === 400) {
                this.errorAlert("Room Already Booked", "The selected room is already booked. Please choose a different room or timeframe.");
            } else {
                this.errorAlert("Unknown error", "The request could not be completed. Please try again later. If the error persists, please contact us at info@luxorahotel.com");
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
};
</script>

<style scoped>
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
