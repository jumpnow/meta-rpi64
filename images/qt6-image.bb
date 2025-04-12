SUMMARY = "A basic Qt qwidgets test image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require console-image.bb

QT_TOOLS = " \
    qtbase \
    qtbase-plugins \
    qtbase-tools \
    qt6-env \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

TSLIB = " \
    tslib-conf \
    tslib-calibrate \
    tslib \
"

IMAGE_INSTALL += " \
    ${FONTS} \
    ${QT_TOOLS} \
    ${TSLIB} \
    tspress-tools \
"

export IMAGE_BASENAME = "qt6-image"
