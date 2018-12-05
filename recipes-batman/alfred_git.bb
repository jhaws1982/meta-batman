DESCRIPTION = "Almighty Lightweight Fact Remote Exchange Daemon for use with B.A.T.M.A.N. Advanced"
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

EXTRA_OEMAKE += "CONFIG_ALFRED_CAPABILITIES=n CONFIG_ALFRED_GPSD=n"

inherit pkgconfig

DEPENDS += " libnl"
RDEPENDS_${PN} += " batctl"
S = "${WORKDIR}/git"

SRCREV = "585fa1fa39bbdf37811655bdb64177af531eb58f"
SRC_URI = "git://git.open-mesh.org/alfred.git \
           file://COPYING \
           file://alfred.sh \
          "

PV = "_git${SRCREV}"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${sbindir}
  install -m 0755 alfred ${D}${sbindir}
  install -m 0755 vis/batadv-vis ${D}${sbindir}
    
  # Install initscripts and links
  install -d ${D}${sysconfdir}
  install -d ${D}${sysconfdir}/init.d/
  install -d ${D}${sysconfdir}/rcS.d/
  install -d ${D}${sysconfdir}/rc0.d/
  install -d ${D}${sysconfdir}/rc1.d/
  install -d ${D}${sysconfdir}/rc2.d/
  install -d ${D}${sysconfdir}/rc3.d/
  install -d ${D}${sysconfdir}/rc4.d/
  install -d ${D}${sysconfdir}/rc5.d/
  install -d ${D}${sysconfdir}/rc6.d/
  install -p ${S}/../alfred.sh ${D}${sysconfdir}/init.d/

  # Links for alfred script
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc0.d/K71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc1.d/K71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc6.d/K71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc2.d/S71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc3.d/S71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc4.d/S71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rc5.d/S71alfred.sh
  ln -sf ../init.d/alfred.sh ${D}${sysconfdir}/rcS.d/S71alfred.sh
}

FILES_${PN} += "${sysconfdir}/init.d/alfred.sh ${sysconfdir}/rc*.d/*alfred.sh"

