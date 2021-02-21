SUMMARY = "A console development image with bluetooth support"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us ja-jp"

DEPENDS += "bootfiles"

inherit image

CORE_OS = "openssh openssh-keygen openssh-sftp-server \
           ntp ntp-tickadj \
           packagegroup-core-boot \
           procps \
           term-prompt \
           tzdata \
          "

DEFAULT_TIMEZONE = "America/Los_Angeles"

KERNEL_EXTRA = "kernel-modules"

WIREGUARD = "wireguard-init \
             ${@bb.utils.contains('WIREGUARD_COMPAT', '1', 'wireguard-module', '', d)} \
             wireguard-tools \
            "

EXTRA_TOOLS = "i2c-tools \
               canutils \
               nmap \
              "

SECURITY_TOOLS = "checksec \
                  ncrack \
                  nikto \
                  python3-scapy \
                 "

BT = "bluez-firmware-rpidistro-bcm4345c0-hcd \
      bt-init \
      bluez5 \
      bluez5-dev \
      bluez5-noinst-tools \
      bluez5-obex \
      bluez5-testtools \
     "

PYTHON_BT = "python3-pybluez"

WIFI = "crda \
        iw \
        linux-firmware-rpidistro-bcm43455 \
        wpa-supplicant \
       "

ALSA += "libasound \
         libavcodec \
         libavdevice \
         libavfilter \
         libavformat \
         libavutil \
         libpostproc \
         libswresample \
         libswscale \
         alsa-conf \
         alsa-state \
         alsa-utils \
         alsa-utils-scripts \
        "

GSTREAMER = "gstreamer1.0 \
             gstreamer1.0-libav \
             gstreamer1.0-meta-base \
             gstreamer1.0-omx \
             gstreamer1.0-plugins-bad \
             gstreamer1.0-plugins-base \
             gstreamer1.0-plugins-base-alsa \
             gstreamer1.0-plugins-good \
             gstreamer1.0-plugins-ugly \
             x264 \
            "

IMAGE_INSTALL += "${ALSA} \
                  ${BT} \
                  ${CORE_OS} \
                  ${EXTRA_TOOLS} \
                  firewall \
                  ${GSTREAMER} \
                  ${KERNEL_EXTRA} \
                  ${PYTHON_BT} \
                  ${SECURITY_TOOLS} \
                  userland \
                  ${WIFI} \
                  ${WIREGUARD} \
                 "

IMAGE_FILE_BLACKLIST += "${sysconfdir}/init.d/hwclock.sh"

remove_blacklist_files() {
    for i in ${IMAGE_FILE_BLACKLIST}; do
        rm -rf ${IMAGE_ROOTFS}$i
    done
}

set_local_timezone() {
    ln -sf ${datadir}/zoneinfo/${DEFAULT_TIMEZONE} ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

disable_rng_daemon() {
    rm -f ${IMAGE_ROOTFS}/etc/rcS.d/S*rng-tools
    rm -f ${IMAGE_ROOTFS}/etc/rc5.d/S*rng-tools
}

ROOTFS_POSTPROCESS_COMMAND += "remove_blacklist_files ; \
                               set_local_timezone ; \
                               disable_bootlogd ; \
                               disable_rng_daemon ; \
                              "

export IMAGE_BASENAME = "weston-image"
