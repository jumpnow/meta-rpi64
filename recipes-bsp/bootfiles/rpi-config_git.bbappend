SRCREV = "648ffc470824c43eb0d16c485f4c24816b32cd6f"

do_deploy_append() {
    sed -i '/#kernel=/ c\kernel=kernel8.img' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

    if [ -n "${DISABLE_SPLASH}" ]; then
        sed -i '/#disable_splash=/ c\disable_splash=${DISABLE_SPLASH}' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi

    # HDMI display rotation
    # 0 = none, 1 = 90cw, 2 = 180cw, 3 = 270cw, 0x10000 = hflip, 0x20000 = vflip
    if [ -n "${DISPLAY_ROTATE}" ]; then
        sed -i '/#display_rotate=/ c\display_rotate=${DISPLAY_ROTATE}' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi

    if [ -n "${ENABLE_RPI3_SERIAL_CONSOLE}" ]; then
        echo "" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "dtoverlay=pi3-disable-bt" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi

    if [ -n "${BAUDRATE_UART}" ]; then
        echo "" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "init_uart_baud=${BAUDRATE_UART}" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi
}

do_deploy_append_raspberrypi4-64() {
    echo "# Enable audio (loads snd_bcm2835)" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "dtparam=audio=on" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
