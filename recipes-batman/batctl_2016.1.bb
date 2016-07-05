DESCRIPTION = "Control application for B.A.T.M.A.N. routing protocol kernel module for multi-hop ad-hoc mesh networks."
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += " libnl"
#DEPENDS += " batman-adv"
#RDEPENDS_${PN} += " kernel-module-batman-adv"
S = "${WORKDIR}/git"

SRCREV = "7a3d563466f368b9b50191f441b775bae46a77ca"
SRC_URI = "git://git.open-mesh.org/batctl.git \
           file://COPYING \
           file://0000_batctl_makefile-flags.patch \
          "

PV = "2016.1_git${SRCREV}"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${bindir}
  install -m 0755 batctl ${D}${bindir}
}
