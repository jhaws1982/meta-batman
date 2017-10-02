DESCRIPTION = "Control application for B.A.T.M.A.N. routing protocol kernel module for multi-hop ad-hoc mesh networks."
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit pkgconfig

DEPENDS += " libnl"
S = "${WORKDIR}/git"

SRCREV = "7e0e9389946fa0c2d3fb3dd9e622db1cb8daff6d"
SRC_URI = "git://git.open-mesh.org/batctl.git \
           file://COPYING \
           file://0001-batctl-Fixing-Makefile-for-Yocto-builds.patch \
          "

PV = "_git${SRCREV}"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${bindir}
  install -m 0755 batctl ${D}${bindir}
}
