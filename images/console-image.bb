SUMMARY = "A custom console development image for the rpi64 boards"
HOMEPAGE = "http://www.jumpnowtek.com"

inherit image

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

DEPENDS += "rpi-bootfiles"

CORE_OS = "\
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    tzdata \
"

KERNEL_EXTRA = "\
    kernel-modules \
"

EXTRA_TOOLS = " \
    bzip2 \
    coreutils \
    curl \
    diffutils \
    dosfstools \
    e2fsprogs-mke2fs \
    ethtool \
    fbset \
    file \
    findutils \
    grep \
    i2c-tools \
    iperf3 \
    iproute2-ifstat iproute2-ip iproute2-nstat iproute2-ss \
    iptables \
    less \
    lsof \
    ltrace \
    netcat-openbsd \
    parted \
    procps \
    strace \
    sysfsutils \
    systemd-analyze \
    tar \
    tcpdump \
    util-linux \
    util-linux-blkid \
    unzip \
    wget \
    zip \
"

SECURITY = " \
    checksec \
    wireguard-tools \
"

WIFI = "\
    iw \
    wpa-supplicant \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${KERNEL_EXTRA} \
    ${EXTRA_TOOLS} \
    ${SECURITY} \
    ${WIFI} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
    echo 'America/New_York' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

export IMAGE_BASENAME = "console-image"
