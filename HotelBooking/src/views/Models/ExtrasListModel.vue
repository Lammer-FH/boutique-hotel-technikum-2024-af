<template>
    <ul class="extras-list">
        <li v-for="extra in extras" :key="extra" class="extra-item">
            <ion-icon :icon="getIcon(extra)"></ion-icon>
            {{ extra }}
        </li>
    </ul>
</template>

<script lang="ts">
import { IonIcon } from '@ionic/vue';
import { wifiOutline, snowOutline, wineOutline, volumeMuteOutline, tvOutline, checkmarkCircleOutline } from 'ionicons/icons';

export default {
    name: 'ExtrasList',
    components: {
        IonIcon
    },
    props: {
        extras: {
            type: Array as () => string[],
            required: true
        }
    },
    methods: {
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
        }
    }
};
</script>

<style scoped>
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
</style>
