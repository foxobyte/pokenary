
function eventThrottle(delay: number, fun: Function) {
    let lastCall = 0;
    return function(...args: any) {
        const now = (new Date).getTime();

        if (now - lastCall < delay) {
            return;
        }

        lastCall = now;
        return fun(...args);
    }
}

export default eventThrottle;