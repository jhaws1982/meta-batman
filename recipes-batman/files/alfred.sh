#! /bin/sh

### BEGIN INIT INFO
# Provides:        alfred
# Required-Start:  $network $syslog
# Required-Stop:   $network $syslog
# Default-Start:   2 3 4 5
# Default-Stop:
# Short-Description: Start alfred data-sharing daemon
### END INIT INFO

PATH=/sbin:/bin:/usr/bin:/usr/sbin
DAEMON=/usr/sbin/alfred
PIDFILE=/var/run/alfred.pid
ALFRED_OPTS="-m -i br0 -p 0.5"

# alfred init.d script
test -x $DAEMON || exit 0

# Source function library.
. /etc/init.d/functions

# Functions to do individual actions
startdaemon(){
	echo -n "Starting alfred: "
	start-stop-daemon -S --make-pidfile -p $PIDFILE -b -a $DAEMON -- $ALFRED_OPTS
	echo "done"
}
stopdaemon(){
	echo -n "Stopping alfred: "
	start-stop-daemon --stop --quiet --oknodo -p $PIDFILE
	echo "done"
}

case "$1" in
  start)
	startdaemon -g
	;;
  stop)
  	stopdaemon
	;;
  force-reload)
  	stopdaemon
	startdaemon -g
	;;
  restart)
  	# Don't reset the tick here
	stopdaemon
	startdaemon -g
	;;
  reload)
  	# Must do this by hand, but don't do -g
	stopdaemon
	startdaemon
	;;
  status)
	status /usr/sbin/alfred;
	exit $?
	;;
  *)
	echo "Usage: alfred.sh { start | stop | status | restart | reload }" >&2
	exit 1
	;;
esac

exit 0
