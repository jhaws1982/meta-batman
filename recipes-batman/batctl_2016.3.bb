DESCRIPTION = "Control application for B.A.T.M.A.N. routing protocol kernel module for multi-hop ad-hoc mesh networks."
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += " libnl"
S = "${WORKDIR}/git"

SRCREV = "c821115dc2d04d3f154318d7af677ae700124e33"
SRC_URI = "git://git.open-mesh.org/batctl.git \
           file://COPYING \
           file://0001-batctl-Fixing-Makefile-for-Yocto-builds.patch \
          "

PV = "2016.3_git${SRCREV}"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${bindir}
  install -m 0755 batctl ${D}${bindir}
}
