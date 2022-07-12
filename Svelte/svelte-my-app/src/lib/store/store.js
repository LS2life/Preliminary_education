import {writable} from "svelte/store"

/* 외부에서 수정 불가 */
export let storeName=writable("Svelte")