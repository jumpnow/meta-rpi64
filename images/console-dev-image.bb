SUMMARY = "A custom console development image for the rpi64 boards"

require console-image.bb

DEV_SDK = " \
    binutils \
    binutils-symlinks \
    cmake \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    elfutils elfutils-binutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    ltrace \
    make \
    perl-modules \
    pkgconfig \
    python3-modules \
    strace \
"

IMAGE_INSTALL += " \
    ${DEV_SDK} \
"

export IMAGE_BASENAME = "console-dev-image"
