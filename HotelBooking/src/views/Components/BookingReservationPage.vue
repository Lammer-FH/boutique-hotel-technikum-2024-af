<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle slot="end">Reservation</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <div class="form-container">
                <h1 class="page-title">Reservation form</h1>
                <form @submit.prevent="saveReservation" class="reservation-form">
                    <IonItem class="form-item">
                        <IonLabel position="floating">Name</IonLabel>
                        <IonInput type="text" v-model="name" required></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Surname</IonLabel>
                        <IonInput type="text" v-model="surname" required></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Email</IonLabel>
                        <IonInput type="email" v-model="email" required></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Confirm Email</IonLabel>
                        <IonInput type="email" v-model="confirmEmail" required></IonInput>
                    </IonItem>
                    <IonItem>
                        <IonLabel>Breakfast</IonLabel>
                        <IonToggle v-model="breakfast"></IonToggle>
                        <IonLabel>{{ breakfastStatus }}</IonLabel>
                    </IonItem>
                    <div class="reservation-button-container">
                        <ion-button type="submit" color="mygreen" class="reservation-button">Submit
                            reservation</ion-button>
                    </div>
                </form>
            </div>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon, IonItem, IonLabel, IonInput, alertController, IonToggle } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import { useBookingStore } from '../Stores/BookingStore';

export default {
    name: 'BookingReservationPage',
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
            name: '',
            surname: '',
            email: '',
            confirmEmail: '',
            breakfast: false,
            roomId: null as number | null,
        };
    },
    computed: {
        breakfastStatus() {
            return this.breakfast === true ? "Yes" : "No";
        },
    },
    methods: {
        navigateBack() {
            this.$router.back();
        },
        async saveReservation() {
            if (!this.checkEmail()) {
                return;
            }
            const bookingStore = useBookingStore();
            bookingStore.setReservation(this.name, this.surname, this.email, this.breakfast);
            this.$router.push({ name: 'BookingReservationCheck' });
        },
        async errorAlert(header: string, message: string) {
            const alert = await alertController.create({
                header: header,
                message: message,
                buttons: ['OK'],
            });
            await alert.present();
        },
        checkEmail() {
            if (this.email !== this.confirmEmail) {
                this.errorAlert("Email error", "The emails do not match. Please correct your input and try again.");
                return false;
            }
            return true;
        },
    },
    setup() {
        return {
            arrowBackOutline,
        };
    },
};
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
